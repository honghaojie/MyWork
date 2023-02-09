import com.hhj.entity.User;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {

    }

    public List<String> sortGetTop3LongWordsByStream(String sentence){
        return Arrays.stream(sentence.split(""))
                .filter(word->word.length()>5)
                .sorted((o1,o2)->o2.length()-o1.length())
                .limit(3)
                .collect(Collectors.toList());
    }

    /**
     * .map 一对一转换
     */
    public void stringToIntMap(){
        List<String> ids = Arrays.asList("1","3","4","5","9","111","31221");
        List<User> results = ids.stream()
                .map(id->{
                    User user = new User();
                    user.setId(id);
                    return user;
                }
        ).collect(Collectors.toList());
    }

    /***
     * .flatMap 多对多转换
     */
    public void stringToIntFlatmap(){
        List<String> sentences = Arrays.asList("Hello world","help me");
        List<String> results = sentences.stream()
                .flatMap(sentence -> Arrays.stream(sentence.split(" ")))
                .collect(Collectors.toList());

    }

    /**
     * 使用拼接
     */
    public void testCollectJoinString(){
        List<String> ids = Arrays.asList("1","2","3","4");
        String joinResult = ids.stream().collect(Collectors.joining(","));
    }

    public void testNumCalculate(){
        List<Integer> ids = Arrays.asList(10,20,30);
        Double average = ids.stream().collect(Collectors.averagingInt(value -> value));

        IntSummaryStatistics summary = ids.stream().collect(Collectors.summarizingInt(value -> value));
    }
}
