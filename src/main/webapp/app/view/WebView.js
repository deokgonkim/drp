Ext.define('DRP.view.WebView', {
    extend: 'Ext.panel.Panel',
    alias: 'widget.webview',
    border: false,
    html: 'https://www.dgkim.net/',
    initComponent: function() {
        this.callParent(arguments);
    }
});