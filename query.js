function single_query(collection,form,param){
    var value = form.elements.namedItem(param).value;
    var comp = "=="
    if(value == ""){
        comp = ">=";
    }
    console.log(param,comp,value);
    var ids = new Array();
    collection.where(param, comp, value)
    .get()
    .then(function(querySnapshot) {
        querySnapshot.forEach(function(doc) {
            //console.log(doc.data());
            ids.push(doc.id);
        });
    })
    return ids;
}

function query(){
    var collection = db.collection("Residents");
    var form = document.getElementById("query");

    set1 = single_query(collection,form,"first");
    set2 = single_query(collection,form,"last");
    set3 = single_query(collection,form,"major");
    set4 = single_query(collection,form,"year");
    set5 = single_query(collection,form,"room_number");
    set6 = single_query(collection,form,"room_letter");

    setTimeout(() => {
        x=set1.filter(value => -1 !== set2.indexOf(value));
        x=x.filter(value => -1 !== set3.indexOf(value));
        x=x.filter(value => -1 !== set4.indexOf(value));
        x=x.filter(value => -1 !== set5.indexOf(value));
        x=x.filter(value => -1 !== set6.indexOf(value));
        print_set(x);
    }, 2000);

    form.reset();
}

function print_set(set){
    for (item in set)
        console.log(set[item]);
}