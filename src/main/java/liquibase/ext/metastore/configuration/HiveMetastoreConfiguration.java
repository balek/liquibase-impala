package liquibase.ext.metastore.configuration;

import liquibase.configuration.AbstractConfigurationContainer;

public class HiveMetastoreConfiguration extends AbstractConfigurationContainer {
    private static final String LOCK = "lock";
    private static final String SYNC_DDL = "syncDDL";

    public HiveMetastoreConfiguration() {
        super("liquibase");
        getContainer().addProperty(LOCK, String.class)
                .setDescription("Should Liquibase lock database while executing")
                .setDefaultValue("true")
                .addAlias("lock");
        getContainer().addProperty(SYNC_DDL, String.class)
                .setDescription("Wrap every statement with SYNC_DDL")
                .setDefaultValue("true")
                .addAlias("syncDDL");
    }

    public boolean getLock() {
        String value = getContainer().getValue(LOCK, String.class);
        return value == null || !value.equals("false");
    }

    public HiveMetastoreConfiguration setLock(boolean noLock) {
        getContainer().setValue(LOCK, noLock);
        return this;
    }

    public boolean getSyncDDL() {
        String value = getContainer().getValue(SYNC_DDL, String.class);
        return value == null || !value.equals("false");    }

    public HiveMetastoreConfiguration setSyncDDL(boolean syncDdl) {
        getContainer().setValue(SYNC_DDL, Boolean.class);
        return this;
    }
}
