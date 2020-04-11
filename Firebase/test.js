function add() {
    // <script src="https://www.gstatic.com/firebasejs/7.13.1/firebase-app.js"></script>
    // <script src="https://www.gstatic.com/firebasejs/7.13.1/firebase-analytics.js"></script>

    var firebaseConfig = {
        apiKey: "AIzaSyDZNTsyONAQlE0c_EtoCcyYyZyRWpz6isI",
        authDomain: "mavra-2355b.firebaseapp.com",
        databaseURL: "https://mavra-2355b.firebaseio.com",
        projectId: "mavra-2355b",
        storageBucket: "mavra-2355b.appspot.com",
        messagingSenderId: "553724586959",
        appId: "1:553724586959:web:e3231272bd5b4ceaa780ba",
        measurementId: "G-FL37NKQY87"
    };

    // Initialize Firebase
    firebase.initializeApp(firebaseConfig);
    firebase.analytics();
    var residents = firebase.database.ref("Residents");

    // Get input values from each of the form elements
    var id = $("#id").val();
    var fname = $("#fname").val();
    var lname = $("#lname").val();
    var major = $("#major").val();
    var year = $("#year").val();
    var room_number = $("#room_number").val();
    var room_letter = $("#room_letter").val();
    
    let resident_data = {
        first: fname,
        last: lname,
        major: major,
        room: {
            number: room_number,
            side: room_letter
        },
        year: year
    };
    // Add a new document in collection "cities" with ID 'LA'
    let new_resident = residents.doc(id).set(resident_data);
}

function del(){
    var firebaseConfig = {
        apiKey: "AIzaSyDZNTsyONAQlE0c_EtoCcyYyZyRWpz6isI",
        authDomain: "mavra-2355b.firebaseapp.com",
        databaseURL: "https://mavra-2355b.firebaseio.com",
        projectId: "mavra-2355b",
        storageBucket: "mavra-2355b.appspot.com",
        messagingSenderId: "553724586959",
        appId: "1:553724586959:web:e3231272bd5b4ceaa780ba",
        measurementId: "G-FL37NKQY87"
    };

    // Initialize Firebase
    firebase.initializeApp(firebaseConfig);
    firebase.analytics();
    var db = firebase.database;

    // Get input values from each of the form elements
    var id = $("#id").val();

    let deleteDoc = db.collection('Residents').doc(id).delete();
}

