package 设计模式.策略模式;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author dongboy
 * @what time    2023/4/11 21:24
 */
public class 策略模式代替if_else {
}

// 常规写法
class NormalTypeJudge {
    public void judgeType(String type) {
        if (type.equals("doc")) {
            System.out.println("doc");
        } else if (type.equals("pdf")) {
            System.out.println("pdf");
        } else {
            System.out.println("excel");
        }
    }
}

// 策略模式改写
interface TypeJudgeStrategy {
    void judgeType(String type);
}

class TypeOfDoc implements TypeJudgeStrategy {

    @Override
    public void judgeType(String type) {
        System.out.println("doc");
    }
}

class TypeOfPdf implements TypeJudgeStrategy {

    @Override
    public void judgeType(String type) {
        System.out.println("pdf");
    }
}

class TypeOfExcel implements TypeJudgeStrategy {

    @Override
    public void judgeType(String type) {
        System.out.println("excel");
    }
}

class TypeJudgeFactory {
    private static final Map<String, TypeJudgeStrategy> map = new HashMap<>();

    static {
        map.put("doc", new TypeOfDoc());
        map.put("pdf", new TypeOfPdf());
        map.put("excel", new TypeOfExcel());
    }

    public static TypeJudgeStrategy getStrategy(String type) {
        return map.get(type);
    }
}

class TestOfTypeJudgeStrategy {
    public static void main(String[] args) {
        String type = "doc";
        TypeJudgeStrategy strategy = TypeJudgeFactory.getStrategy(type);
        strategy.judgeType(type);
    }
}
