<!-- Juan Diego Gonzalez German
ID: 1001401837 -->

<?php
    $host = "localhost";
    $dbusername = "root";
    $dbpassword = "";
    $dbname = "doctoral";
    echo "<body style='background-color:whitesmoke'>";
    // Create connection
    $conn = new PDO('mysql:host='.$host.';dbname='.$dbname, 
                    $dbusername, $dbpassword);
    // Check connection
    if(!$conn) {
        die("Connection failed");
    }
    else {
        $fname = filter_input(INPUT_POST, 'fname');
        $lname = filter_input(INPUT_POST, 'lname');
        $id = filter_input(INPUT_POST, 'id');
        $StSemester = filter_input(INPUT_POST, 'StSemester');
        $StYear = filter_input(INPUT_POST, 'StYear');
        $supervisor = filter_input(INPUT_POST, 'supervisor');

        $query1 = " INSERT INTO phdstudent (StudentId, Fname, LName, StSem, StYear, Supervisor)
                    values ('$id','$fname', '$lname', '$StSemester','$StYear', '$supervisor')";

        $query2 = " INSERT INTO selfsupport (StudentId)
                    values ('$id')";

        if ($conn->query($query1) and $conn->query($query2)){
            echo "Record added sucessfully";
        }

        else{
            echo "Error: ". $conn->errorInfo()[0];
        }
    }
?>