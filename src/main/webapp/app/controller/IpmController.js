Ext.define('DRP.controller.IpmController', {
    extend: 'Ext.app.Controller',
    init: function() {
        this.control({
            'iplistgrid': {
                render: this.onLoad
            }
        });
        console.log('Initialized IpmController!');
    },
    onLoad: function(component, e) {
        this.getIpAddressesStore().load();
        this.getIplistgrid().on({
            edit: this.onEdit,
            scope: this
        });
    },
    onEdit: function(e, eOpts) {
        e.store.sync();
    },
    refs: [{
        selector: 'viewport > #tabPanel > iplistgrid',
        ref: 'iplistgrid'
    }],
    stores: [ 'IpAddresses' ],
    models: [ 'IpAddress' ],
    views: [ 'IpListGrid' ]
});