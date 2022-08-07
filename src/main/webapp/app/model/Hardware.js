Ext.define('DRP.model.Hardware', {
    extend: 'Ext.data.Model',
    fields: [
        'id',
        'hardwareType',
        'manufacturer',
        'modelName',
        'serialNumber',
        'owner',
        'description'
    ],
    
    proxy: {
        type: 'ajax',
        url: 'data/hardwares.json',
        reader: {
            type: 'json',
            root: 'hardwares',
            successProperty: 'success'
        }
    }
});
