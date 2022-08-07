Ext.define('DRP.store.Users', {
    extend: 'Ext.data.Store',
    model: 'DRP.model.User',
    autoLoad: true,
    sorters: {
        property: 'displayName',
        direction: 'ASC'
    }
});