package Pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.*;

@Component @Lazy
public class DBExecutor  extends NamedParameterJdbcDaoSupport {
    public DBExecutor(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }

    public static List<Map<String, Object>> resultList;

    public List<Map<String, Object>> getDBVerificationResult(String sqlQuery) {
//        sqlQuery = sqlQuery.replace("\n", "").replace("           ", "");
//        if (sqlQuery.contains("verify_ID"))
//            sqlQuery = sqlQuery.replace("verify_ID", verifyID);
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(getJdbcTemplate().getDataSource());

        namedParameterJdbcTemplate.query(sqlQuery, new ResultSetExtractor<List<String>>() {
            @Override
            public List<String> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                resultList = new ArrayList<Map<String, Object>>();
                Map<String, Object> row = null;
                ResultSetMetaData metaData = resultSet.getMetaData();
                Integer columnCount = metaData.getColumnCount();
                while (resultSet.next()) {
                    row = new HashMap<String, Object>();
                    for (int i = 1; i <= columnCount; i++) {
                        row.put(metaData.getColumnName(i), resultSet.getObject(i));
                    }
                    resultList.add(row);
                }
                return null;
            }
        });
        return resultList;
    }


    @Autowired
    @Qualifier("stagingQADataSource")
    public void setDataSource0(DataSource dataSource) {
        setDataSource(dataSource);
    }

}
