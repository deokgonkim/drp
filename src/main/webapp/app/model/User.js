Ext.define('DRP.model.User', {
    extend: 'Ext.data.Model',
    fields: [ 'dn', 'displayName' ],
    
    proxy: {
        type: 'ajax',
        url: 'data/users.json',
        reader: {
            type: 'json',
            root: 'users',
            successProperty: 'success'
        }
    }
});
