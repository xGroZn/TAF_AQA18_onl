package dbTables;

import models.ProjectBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import services.DataBaseService;

import java.sql.ResultSet;

public class ProjectsTable {
    Logger logger = LogManager.getLogger(ProjectsTable.class);

    private DataBaseService dbService;

    public ProjectsTable(DataBaseService dbService) {
        this.dbService = dbService;
    }

    public void createTable() {
        logger.info("Создаем projects таблицу");

        String createTableSQL = "" +
                "create table public.projects " +
                "(id SERIAL PRIMARY KEY," +
                "    name CHARACTER VARYING(30)," +
                "    announcement CHARACTER VARYING(200)," +
                "    type INTEGER," +
                "    showannouncement BOOLEAN" +
                ");";

        dbService.executeSQL(createTableSQL);
    }

    public void dropTable() {
        logger.info("Удаляем projects таблицу");

        String dropTableSQL = "drop table if exists public.projects;";

        dbService.executeSQL(dropTableSQL);
    }

    public ResultSet getProjects() {
        String sql = "SELECT * FROM public.projects;";

        return dbService.executeQuery(sql);
    }

    public ResultSet getProjectById(int id) {
        String sql = "SELECT * FROM public.projects WHERE id = " + id + ";";

        return dbService.executeQuery(sql);
    }

    public void addProject(ProjectBuilder projectBuilder) {
        String insertTableSQL = "INSERT INTO public.projects(" +
                "name, announcement, type, showannouncement)" +
                "VALUES ('" + projectBuilder.getName() + "', '" + projectBuilder.getAnnouncement() +
                "', '" + projectBuilder.getType() + "', " + projectBuilder.isShowAnnouncement() + ");";

        dbService.executeSQL(insertTableSQL);
    }

}