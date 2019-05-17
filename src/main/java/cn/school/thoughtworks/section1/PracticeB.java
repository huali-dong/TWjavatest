package cn.school.thoughtworks.section1;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class PracticeB {
    List<String> collectSameElements(List<String> collection1, List<List<String>> collection2) {
        //实现练习要求，并改写该行代码。
        List<String> col2 = collection2.stream().flatMap(Collection::stream).collect(Collectors.toList());
        return collection1.stream().filter(col2::contains).collect(Collectors.toList());
    }
}
