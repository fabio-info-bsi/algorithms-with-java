package br.com.fabex.problems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ReadHtmlAndFindDeepTag {

    private static int level = 0;

    static class Tag {
        String name;
        String val;
        int level;
        List<Tag> childrenTag;

        Tag(String name, String val, int level, List<Tag> childrenTag) {
            this.name = name;
            this.val = val;
            this.level = level;
            this.childrenTag = childrenTag;
        }
    }

    public static void main(String[] args) {
        String response = requestByUrl("http://hiring.axreng.com/internship/example1.html");
        /* Removing space and newLines */
        response = response.replaceAll("\\r\\n|\\r|\\n", "");
        Tag rootTag = readStringHtmltoTag(response);
        Tag tagMoreDeep = findTagMoreDeep(rootTag);
        System.out.println("Html: " + response);
        System.out.println("Tag: " + tagMoreDeep.name);
        System.out.println("Level: " + tagMoreDeep.level);
        System.out.println("Value: " + tagMoreDeep.val);
    }

    private static String requestByUrl(String url) {
        String response;
        try {
            try (BufferedReader br = new BufferedReader(new InputStreamReader(
                    new URL(url).openConnection().getInputStream()))) {
                response = br.lines().collect(Collectors.joining());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return response;
    }

    private static Tag readStringHtmltoTag(final String html) {
        return readStringHtml(html).getFirst();
    }

    private static List<Tag> readStringHtml(final String html) {
        String regex = "<(\\w+)[^>]*>(.*?)</?\\1>";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(html);

        List<Tag> tags = new ArrayList<>();
        while (matcher.find()) {
            Tag tag = new Tag(matcher.group(1), matcher.group(2), level, new ArrayList<>());
            level++;
            tag.childrenTag = readStringHtml(matcher.group(2));
            level--;
            tags.add(tag);
        }
        return tags;
    }

    private static Tag findTagMoreDeep(Tag root) {
        return findTagMoreDeep(root, null);
    }

    private static Tag findTagMoreDeep(Tag root, Tag tagMoreDeep) {

        if (null == root)
            return null;

        if (null == root.childrenTag)
            return root;

        if (null == tagMoreDeep)
            tagMoreDeep = new Tag("more-deep", null, 0, null);

        if (root.level > tagMoreDeep.level) {
            tagMoreDeep = root;
        }

        for (Tag tag : root.childrenTag)
            if (null != tag)
                tagMoreDeep = findTagMoreDeep(tag, tagMoreDeep);

        return tagMoreDeep;
    }

}
