package com.mypersonalupdates.db.actions;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;

public interface AttributeFilterActions {
    @SqlUpdate("INSERT INTO attribute_filter (ID, attrID, fieldValue, type) VALUES (:ID, :attrID, :fieldValue, :type)")
    int create(
            @Bind("ID") Integer ID,
            @Bind("attrID") Integer attrID,
            @Bind("fieldValue") String fieldValue,
            @Bind("type") String type
    );

    @SqlQuery("REMOVE FROM attribute_filter WHERE ID = :ID LIMIT 1")
    Integer remove(
            @Bind("ID") Integer ID
    );

    @SqlQuery("SELECT type FROM attribute_filter WHERE filterID = :ID")
    String getTypeFromID(
            @Bind("ID") Integer ID
    );

    @SqlQuery("SELECT ID FROM attribute_filter WHERE attrID = :attrID AND fieldValue = VALUE LIMIT 1")
    Integer getIDFromContent(
            @Bind("attrID") Integer attrID,
            @Bind("value") String value
    );
}
