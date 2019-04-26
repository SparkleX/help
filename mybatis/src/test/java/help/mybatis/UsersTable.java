package help.mybatis;

import java.sql.JDBCType;

import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public class UsersTable extends SqlTable {
    public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);

    public UsersTable() {
        super("users");
    }
}