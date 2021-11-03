import java.util.StringJoiner;

/**
 * @author thrfur
 * 使用 StringJoiner 构造一个 SELECT 语句
 */
public class StringJoinnerSELECT {
    public static void main(String[] args) {
        String[] fields = { "name", "position", "salary" };
        String table = "employee";
        String select = buildSelectSql(table, fields);
        System.out.println(select);
        System.out.println("SELECT name, position, salary FROM employee".equals(select) ? "测试成功" : "测试失败");
    }

    /**
     *
     * @param table 表名
     * @param fields 表中字段
     * @return java.lang.Sring
     */
    static String buildSelectSql(String table, String[] fields){
        StringJoiner sj = new StringJoiner(", ", "SELECT ", " FROM " + table);
        for (String field:fields){
            sj.add(field);
        }
        return sj.toString();
    }
}
