package cn.school.thoughtworks.section3;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PracticeD {
    Map<String,Integer> createUpdatedCollection(List<String> collectionA, Map<String,List<String>> object) {
        //实现练习要求，并改写该行代码。
        Map<String, Long> map = collectionA.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        HashMap<String,Integer> col = new HashMap<>();

        map.entrySet().forEach(entry->{
            String key = entry.getKey();
            if(key.contains("-")){
                int splitIndex = key.indexOf("-");
                String keys = key.substring(0,splitIndex);
                Integer num = Integer.parseInt(key.substring(splitIndex+1));
                if(col.containsKey(keys)){
                    col.put(keys,col.get(keys)+num);
                }else{
                    col.put(keys,num);
                }
            }else{
                col.put(key,Integer.parseInt(entry.getValue().toString()));
            }
        });
        //获取所有的值
        List<String> col2 = object.entrySet().stream().map(Map.Entry::getValue).flatMap(Collection::stream).collect(Collectors.toList());
        //当满3时减1
        col.entrySet().forEach(entry->{
            String key = entry.getKey();
            if (col2.contains(key)){
                entry.setValue(entry.getValue()-entry.getValue()/3);
            }
        });
        return col;
    }
}
