package com.mypersonalupdates.filters;

import com.mypersonalupdates.Filter;
import com.mypersonalupdates.Update;
import com.mypersonalupdates.db.DBException;

public class AndFilter extends CompoundFilter{

    static final String DATABASE_TYPE = "AndFilter";

   public static AndFilter create(Integer ID) throws DBException {
       Filter  filterID1 = CompoundFilter.getFilter1FromID(ID),
               filterID2 = CompoundFilter.getFilter2FromID(ID);

       if (filterID1 != null && filterID2 != null)
           return new AndFilter(ID, filterID1, filterID2);

       return null;
   }

   private AndFilter(Integer ID, Filter filter1, Filter filter2) {
       super(ID, filter1, filter2);
   }

   public static AndFilter create(Filter filter1, Filter filter2) throws DBException {
       Integer filterID;
       filterID = CompoundFilter.create(filter1, filter2, DATABASE_TYPE);
       return filterID == null ? null : new AndFilter(filterID, filter1, filter2);
   }

    @Override
    public boolean test(Update update) {
        return this.filter1.test(update) && this.filter2.test(update);
    }
}
