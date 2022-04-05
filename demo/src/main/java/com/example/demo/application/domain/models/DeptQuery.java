package com.example.demo.application.domain.models;

import java.io.Serializable;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.example.demo.application.common.constants.QueryName;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@SqlResultSetMapping(name = QueryName.GET_DEPT, classes = {
        @ConstructorResult(targetClass = DeptQuery.class, columns = {
                @ColumnResult(name = "id", type = Long.class),
                @ColumnResult(name = "name", type = String.class)
        })
})
// @formatter:off
@NamedNativeQuery(name = QueryName.GET_DEPT,
query = 
    "SELECT\n" +
    " id,\n" +
    " name\n" + 
    "FROM\n" +
    " dept\n" +
    "WHERE\n" +
    " id = :id\n",
    resultSetMapping = QueryName.GET_DEPT
)
// @formatter:on
public class DeptQuery implements Serializable {

    private static final long serialVersionUID = 1l;

    // ID
    @Id
    @Column(name = "id")
    private long id;

    // 氏名
    @Column(name = "name")
    private String name;

}
