import java.util.*;

/**
 * @author Mike
 */
public class HashmapTest {
    public static void main(String[] args) {
        HashMap<Integer,User> users = new HashMap<>();
        users.put(1,new User("gl",2));
        users.put(2,new User("wxt",3));
        users.put(3,new User("fzj",8));
        System.out.println(users);
        HashMap<Integer,User> sortHashMap = sortHashMap(users);
        System.out.println(sortHashMap);
    }
    public static HashMap<Integer,User> sortHashMap(HashMap<Integer,User> map){
        //首先拿到map的键值对集合
        Set<Map.Entry<Integer,User>> entrySet = map.entrySet();
        //将set集合转为List集合
        List<Map.Entry<Integer,User>> list = new ArrayList<Map.Entry<Integer, User>>(entrySet);
        Collections.sort(list, new Comparator<Map.Entry<Integer, User>>() {
            @Override
            public int compare(Map.Entry<Integer, User> o1, Map.Entry<Integer, User> o2) {
                return o2.getValue().getAge()-o1.getValue().getAge();
            }
        });
        //创建一个新的有序的HashMap子类的集合
        LinkedHashMap<Integer,User> linkedHashMap = new LinkedHashMap<>();
        //将list中的数据存到linkedHashMap里
        for (Map.Entry<Integer,User> entry : list){
            linkedHashMap.put(entry.getKey(),entry.getValue());
        }
        return linkedHashMap;
    }
}
class User{
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
