package dbTables;

import lombok.NonNull;
import lombok.ToString;
import models.MilestoneBuilder;
import models.ProjectBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;
import services.DataBaseService;

import java.sql.ResultSet;

public class MilestonesTable {
    Logger logger = LogManager.getLogger(MilestonesTable.class);

    private DataBaseService dbService;

    public MilestonesTable(DataBaseService dbService) {
        this.dbService = dbService;
    }

    public void createTable() {
        logger.info("Создаем milestones таблицу");

        String createTableSQL = "" +
                "create table public.milestones " +
                "(id SERIAL PRIMARY KEY," +
                "    name CHARACTER VARYING(30)," +
                "    description CHARACTER VARYING(200)" +
                ");";

        dbService.executeSQL(createTableSQL);
    }


        public void dropTable() {
        logger.info("Удаляем milestones таблицу");

        String dropTableSQL = "drop table if exists public.milestones;";

        dbService.executeSQL(dropTableSQL);
    }

    public ResultSet getMilestones() {
        String sql = "SELECT * FROM public.milestones;";

        return dbService.executeQuery(sql);
    }

    public ResultSet getMilestoneById(int id) {
        String sql = "SELECT * FROM public.milestones WHERE id = " + id + ";";

        return dbService.executeQuery(sql);
    }

    public void addMilestone(MilestoneBuilder milestoneBuilder) {
        String insertTableSQL = "INSERT INTO public.milestones(" +
                "name, description)" +
                " VALUES ('" + milestoneBuilder.getName() + "', '" + milestoneBuilder.getDescription() + "');";
        System.out.println(insertTableSQL);

        dbService.executeSQL(insertTableSQL);
    }
}
