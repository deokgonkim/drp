Ext.define('DRP.store.IpAddresses', {
    extend: 'Ext.data.Store',
    model: 'DRP.model.IpAddress',
    autoLoad: false,
    sorters: [ 'ipAddress' ]
});