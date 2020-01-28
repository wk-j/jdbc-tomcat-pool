--=====================================================
--Database Connections Using dm_os_performance_counters
--=====================================================

SELECT oPC.cntr_value AS connection_count
FROM sys.dm_os_performance_counters oPC
WHERE (oPC.[object_name] = 'SQLServer:General Statistics'
       AND oPC.counter_name = 'User Connections')
ORDER BY 1;