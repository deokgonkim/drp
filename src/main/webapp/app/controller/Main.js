Ext.define('DRP.controller.Main', {
    extend: 'Ext.app.Controller',
    init: function() {
        this.control({
            'menutree' : {
                itemclick: this.openPanel
            }
        });
        this.application.on({
            tabopen: this.onTabOpen,
            scope: this
        });
        console.log('Initialized Main!');
    },
    onTabOpen: function(tabId, tabName, viewName) {
        var openedTab = this.getTabPanel().down(viewName);
        if ( openedTab == null ) {
            var newTab = null;
            if ( viewName == 'webview') {
                newTab = this.getTabPanel().add({
                    id: tabId,
                    title: tabName,
                    xtype: viewName,
                    closable: true,
                    html: '<iframe width="100%" height="100%" src="https://www.dgkim.net/wordpress/"></iframe>'
                });
            } else {
                newTab = this.getTabPanel().add({
                    id: tabId,
                    title: tabName,
                    xtype: viewName,
                    closable: true
                });
            }
            this.getTabPanel().setActiveTab(newTab);
        } else {
            this.getTabPanel().setActiveTab(openedTab);
        }
    },
    openPanel: function(obj, record, item, index, e, eOpts) {
        this.application.fireEvent('tabopen', record.data.id, record.data.text, record.data.viewname);
    },
    refs: [{
        selector: 'viewport > #tabPanel',
        ref: 'tabPanel'
    }],
    stores: [ 'Menus', 'Users'],
    models: [ 'Menu', 'User' ],
    views: [
        'MenuTree',
        'WebView'
    ]
});