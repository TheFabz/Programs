/**
 * Convert a binary String to a Number
 */
exports.binaryToDecimal = function(str) {
  
    result = parseInt(str,2);

    return result;
    
};

/**
 * Add two Numbers with a precision of 2
 */
exports.add =  function(a, b) {

    var num = (a + b).toPrecision(1);

    var result = parseFloat(num);

    return result;
};

/**
 * Multiply two Numbers with a precision of 4
 */
exports.multiply =  function(a, b) {

    var num = (a * b).toPrecision(3);

    var result = parseFloat(num);

    return result;

};
