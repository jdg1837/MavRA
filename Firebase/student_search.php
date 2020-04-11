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
        if ($query = "  SELECT phd.StudentId, phd.FName, phd.LName, phd.StSem, phd.StYear, ins.InstructorId, ms.MId, msp.PassDate
                        FROM phdstudent as phd
                        JOIN instructor as ins ON ins.InstructorId = phd.Supervisor
                        LEFT JOIN milestonepassed as msp ON msp.StudentId = phd.StudentId
                        NATURAL LEFT JOIN milestone as ms
                        WHERE ((phd.FName = '$fname' and phd.LName = '$lname') or phd.StudentId = '$id')
                        ORDER BY msp.PassDate") {
                                
            if($query==null){
                echo "No Record Available";
                die();
            }

            else{
                $stmt = $conn->prepare($query);
                $stmt->execute(array(':fname' => $fname, ':lname' => $lname, ':id' => $id));
                $rows = $stmt->fetchALL(PDO::FETCH_ASSOC);
                echo "<body style='background-color:whitesmoke'>";
                ?>
                <table style="width:100%">
                <tr align="left">
                    <th>StudentId</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Start Semester</th>
                    <th>Start Year</th>
                    <th>Supervisor</th>
                    <th>MId</th>
                    <th>PassDate</th>
                </tr>
                <?php
                foreach ($rows as $row) {
                    echo "<tr align=\"left\">";
                    echo "<td>".$row["StudentId"]."</td>";
                    echo "<td>".$row["FName"]."</td>";
                    echo "<td>".$row["LName"]."</td>";
                    echo "<td>".$row["StSem"]."</td>";
                    echo "<td>".$row["StYear"]."</td>";
                    echo "<td>".$row["InstructorId"]."</td>";
                    echo "<td>".$row["MId"]."</td>";
                    echo "<td>".$row["PassDate"]."</td>";
                    echo "</tr>";
                }
            }
        }
    }
?>