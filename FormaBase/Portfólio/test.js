var array = [ 65 , 3 , 10 , 55 , 8 , 6 , 1 , 9 , 88 , 12 , 123, 142, 0, 1412, 1, 76, 13, 15, 89, 101, 100, 99, 12,12 ];

var insertionSort = function ( array ) {

        for ( var i = 1 ; i < array.length ; i++) {

                for (var j = i ; j > 0 ; j--) {

                        console.log(array[j]);


                        if ( array[j] < array[j-1] ) {

                                const save = array[j];

                                array[j] = array[j-1];

                                array[j-1] = save;

                        }


                        else {
                                console.log("changing order!");

                        }
                }

        }

        return array;

}


console.log(insertionSort(array));
