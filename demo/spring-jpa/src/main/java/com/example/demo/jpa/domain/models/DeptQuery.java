package com.example.demo.jpa.domain.models;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.example.demo.jpa.common.constants.QueryName;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@SqlResultSetMapping(name = QueryName.GET_DEPT,
        classes = {@ConstructorResult(targetClass = DeptQuery.class,
                columns = {@ColumnResult(name = "id", type = Long.class),
                        @ColumnResult(name = "name", type = String.class)})})
// @formatter:off
// CHECKSTYLE:OFF
@NamedNativeQuery(name = QueryName.GET_DEPT,
query = 
    "SELECT\n" +
    " id,\n" +
    " name\n" + 
    "FROM\n" +
    " dept\n" +
    "WHERE\n" +
    " id = :paramId\n",
    resultSetMapping = QueryName.GET_DEPT
)
// CHECKSTYLE:ON
// @formatter:on
public class DeptQuery implements Serializable {

    private static final long serialVersionUID = 1L;

    /** ID. */
    @Id
    @Column(name = "id")
    private long id;

    /** 氏名. */
    @Column(name = "name")
    private String name;

}
