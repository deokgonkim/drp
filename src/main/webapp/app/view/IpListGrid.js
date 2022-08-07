Ext.define('DRP.view.IpListGrid', {
    extend: 'Ext.grid.Panel',
    alias: 'widget.iplistgrid',
    border: false,
    store: 'IpAddresses',
    selType: 'rowmodel',
    initComponent: function() {
        this.columns = [
            { header: 'IP주소', dataIndex: 'ipAddress', flex: 1 },
            { header: 'MAC주소', dataIndex: 'macAddress', flex: 1, editor: 'textfield' },
            { header: '소속', dataIndex: 'org', flex: 1, editor: 'textfield' },
            { header: '관리자', dataIndex: 'manager', flex: 1, renderer: this.getDisplayName, editor: { xtype: 'combo', queryMode: 'local', store: 'Users', displayField: 'displayName', valueField: 'dn' } },
            { header: '사용자', dataIndex: 'owner', flex: 1, renderer: this.getDisplayName, editor: { xtype: 'combo', queryMode: 'local',  store: 'Users', displayField: 'displayName', valueField: 'dn' } },
            { header: '비고', dataIndex: 'description', flex: 1, editor: 'textfield' }
        ];
        this.callParent(arguments);
    },
    getDisplayName: function(dn) {
        var users = Ext.data.StoreManager.lookup('Users');
        if ( dn != null && dn.length > 1 ) {
            if ( users.find('dn', dn) != -1 ) {
                return users.getAt( users.find('dn', dn) ).get('displayName');
            }
        }
        return dn;
    },
    plugins: [
        Ext.create('Ext.grid.plugin.RowEditing', {
            autoCancel: true,
            clicksToEdit: 1
        })
    ],
    tbar: [{
        text: 'Print',
        iconCls: 'icon-print',
        handler : function(){
            Ext.ux.grid.Printer.printAutomatically = false;
            Ext.ux.grid.Printer.print(this.up('grid'));
        }
    }]
});