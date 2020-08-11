dataSource {
    pooled = true
    jmxExport = true
    driverClassName = "org.postgresql.Driver"
    username = "postgres"
    password = "postgres"
}

hibernate {
    cache.use_second_level_cache = true
    cache.us//    cache.region.factory_class = 'net.sf.ehcache.hibernate.EhCacheRegionFactory' // Hibernate 3
    cache.region.factory_class = 'org.hibernate.cache.ehcache.EhCacheRegionFactory' // Hibernate 4
    singleSession = true // configure OSIV singleSession mode
    flush.mode = 'manual' // OSIV session flush mode outside of transactional context
}

// environment specific settings
environments {
    development {
        dataSource {
            dbCreate = "update" // one of 'create', 'create-drop', 'update', 'validate', ''
           //url = "jdbc:postgresql://localhost:5433/k5july1" // MBPhil test server
            url = "jdbc:postgresql://192.168.1.220:7477/icbs" //
        }
    }
    test {
        dataSource {
            dbCreate = "update"
           //url = "jdbc:postgresql://localhost:5433/k5july1" //
            url = "jdbc:postgresql://192.168.1.220:7477/icbs" //
        }
    }
    production {
        dataSource {
            dbCreate = "update"
           // url = "jdbc:postgresql://localhost:5433/k5july1" //
            url = "jdbc:postgresql://192.168.1.220:7477/icbs" //
        }
    }
}
