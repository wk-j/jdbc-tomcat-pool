EXEC sp_configure 'show advanced options',
                  1;

RECONFIGURE;

EXEC sp_configure 'user connections',
                  2000;

RECONFIGURE;