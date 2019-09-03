package com.metacube.EADSession5.factory;

import java.sql.SQLException;

import com.metacube.EADSession5.dao.ProductDao;
import com.metacube.EADSession5.enums.DBType;

public class Factory {
       
    /**
     * This method creates and returns ProductDao type Object
     * @return {ProductDao} ProductDao Object
     */
    public static ProductDao createProductDao(DBType dbType){
        try {
			return new ProductDao(dbType);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return null;
		}
    }
}
