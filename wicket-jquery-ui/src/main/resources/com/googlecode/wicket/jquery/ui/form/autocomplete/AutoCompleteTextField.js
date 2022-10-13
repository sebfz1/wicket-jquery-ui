var WJQUI = WJQUI || {};

WJQUI.AutoComplete = function(id, choicesUrl, selectUrl) {
    this.id = id;
    this.choicesUrl = choicesUrl;
    this.selectUrl = selectUrl;
}

// we fetch items here
WJQUI.AutoComplete.prototype.fetchItems = function(request, response) {
    if (this.xhr) {
        // if there is a request being made, then stop it
        this.xhr.abort();
    }
    const self = this;
    this.xhr = $.ajax( {
        url: this.choicesUrl,
        data: {'term': request.term},
        dataType: "json",
        success: function( data ) {
            response( data );
            self.xhr = null;
        },
        error: function() {
            response( [] );
            self.xhr = null;
        }
    } );
}

// function executed in order to select an element in dropdown
WJQUI.AutoComplete.prototype.select = function (event, ui) {
    // in case the user selects something while a new request is running
    if (this.xhr) {
        // then we cancel user selection as we could select something
        // at client side that corresponds to something else at server side
        // (after second request for data is processed at server side)
        event.preventDefault();
        event.stopPropagation();
        return;
    }
    const attrs = {
        "u": this.selectUrl,
        "c": this.id,
        "ep": [{"name": "index", "value": ui.item.id}]
    };
    Wicket.Ajax.ajax(attrs);
}
