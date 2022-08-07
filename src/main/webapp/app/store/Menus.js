Ext.define('DRP.store.Menus', {
    extend: 'Ext.data.TreeStore',
    model: 'DRP.model.Menu',
    autoLoad: true,

    proxy: {
        actionMethods: {
            create: 'POST',
            destroy: 'DELETE',
            read: 'GET',
            update: 'POST'
        },
        type: 'ajax',
        url: 'data/static-menus.json',
        reader: {
            type: 'json',
            root: 'menus'
        }
    },
    root: {
        id: 'menus'
    }
});