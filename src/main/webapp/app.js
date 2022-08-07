/**
 * This application is built with ExtJS
 * 
 * ExtJS
 *  * Homepage : http://www.sencha.com/
 *  * version : 4.0.7-gpl
 *  
 * Loiane's grid print plugin
 *  * Homepage : http://loianegroner.com/2011/09/extjs-4-grid-printer-plugin/
 *  * version : https://github.com/loiane/extjs4-ux-gridprinter/tarball/master
 */
Ext.Loader.setConfig({
    enabled: true,
    paths: {
        'Ext.ux': './ux'
    }
});

Ext.require([
    'Ext.ux.grid.Printer',
]);

Ext.application({
    name: 'DRP',
    appFolder: 'app',
    autoCreateViewport: true,
    launch: function() {
        
    },
    controllers: [
        'Main',
        'IpmController',
        'HardwareController',
        'SoftwareController'
    ]
});
