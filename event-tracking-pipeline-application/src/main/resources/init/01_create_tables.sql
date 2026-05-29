CREATE DATABASE IF NOT EXISTS my_bigdata;

-- Raw table — mirrors ODPS kafka_supply_track_log_rt
CREATE TABLE IF NOT EXISTS my_bigdata.kafka_supply_track_log_rt (
    year       String,
    month      String,
    day        String,
    hour       String,
    namespace  String,
    sceneKey   String,
    sceneDesc  String,
    dateTime   String,
    timestamp  Int64,
    traceId    String,
    spanId     String,
    data       String,
    message    String
)
ENGINE = MergeTree()
PARTITION BY (year, month, day, hour)
ORDER BY (namespace, sceneKey, timestamp);

-- T-1 scene table — mirrors ODPS kafka_supply_track_log_rt_scene
CREATE TABLE IF NOT EXISTS my_bigdata.kafka_supply_track_log_rt_scene (
    pt         String,
    namespace  String,
    sceneKey   String,
    sceneDesc  String,
    dateTime   String,
    timestamp  Int64,
    traceId    String,
    spanId     String,
    data       String
)
ENGINE = MergeTree()
PARTITION BY pt
ORDER BY (namespace,sceneKey);