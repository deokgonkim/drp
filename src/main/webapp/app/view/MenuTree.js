Ext.define('DRP.view.MenuTree', {
    extend: 'Ext.tree.Panel',
    alias: 'widget.menutree',
    border: false,
    store: 'Menus',
    initComponent: function() {
        this.callParent(arguments);
    }
});