package com.example.allinall;

import java.sql.Connection;
import java.sql.DriverManager;

//Вообще, стоит сразу сказать, что данная датабаза берётся с локального сервера, то есть с машины, на которой я всё это писал.
//Значит для запуска на другой машине нужно будет не только иметь базу (я её добавлю в репрезенторий), но и создать сервер.
public class Database
    {
     public Connection databaseLink;

     public Connection getConnection()
         {
          String databaseName = "base"; //название датабазы (кормит)
          String databaseUser = "root"; //пользователь датабазы
          String databasePassword = "root"; //пароль
          String url = "jdbc:mysql://localhost/" + databaseName;

          try
          {
                Class.forName("com.mysql.cj.jdbc.Driver");
                databaseLink = DriverManager.getConnection(url, databaseUser, databasePassword);
                System.out.println("База данных подключена");
          }
          catch (Exception exp)
          {
              System.out.println("База данных не подключена, проверьте настройки");
              exp.printStackTrace();
          }
            return databaseLink;
         }
    }
