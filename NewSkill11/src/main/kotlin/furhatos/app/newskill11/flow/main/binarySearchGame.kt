package furhatos.app.newskill11.flow.main

import furhatos.records.Location
import furhatos.flow.kotlin.*
import furhatos.app.newskill11.flow.Parent

import furhatos.app.newskill11.flow.nlu.*

import furhatos.app.newskill11.flow.Parent
import furhatos.app.newskill11.flow.nlu.GameIntent
import furhatos.app.newskill11.flow.nlu.JokeIntent
import furhatos.flow.kotlin.State
import furhatos.flow.kotlin.furhat
import furhatos.flow.kotlin.onResponse
import furhatos.flow.kotlin.state
import furhatos.nlu.common.No
import furhatos.nlu.common.Yes

val numberToWordMap = mutableMapOf<Int, String>(
    0 to "zero",
    1 to "one",
    2 to "two",
    3 to "three",
    4 to "four",
    5 to "five",
    6 to "six",
    7 to "seven",
    8 to "eight",
    9 to "nine",
    10 to "ten",
    11 to "eleven",
    12 to "twelve",
    13 to "thirteen",
    14 to "fourteen",
    15 to "fifteen",
    16 to "sixteen",
    17 to "seventeen",
    18 to "eighteen",
    19 to "nineteen",
    20 to "twenty",
    21 to "twenty-one",
    22 to "twenty-two",
    23 to "twenty-three",
    24 to "twenty-four",
    25 to "twenty-five",
    26 to "twenty-six",
    27 to "twenty-seven",
    28 to "twenty-eight",
    29 to "twenty-nine",
    30 to "thirty",
    31 to "thirty-one",
    32 to "thirty-two",
    33 to "thirty-three",
    34 to "thirty-four",
    35 to "thirty-five",
    36 to "thirty-six",
    37 to "thirty-seven",
    38 to "thirty-eight",
    39 to "thirty-nine",
    40 to "forty",
    41 to "forty-one",
    42 to "forty-two",
    43 to "forty-three",
    44 to "forty-four",
    45 to "forty-five",
    46 to "forty-six",
    47 to "forty-seven",
    48 to "forty-eight",
    49 to "forty-nine",
    50 to "fifty",
    51 to "fifty-one",
    52 to "fifty-two",
    53 to "fifty-three",
    54 to "fifty-four",
    55 to "fifty-five",
    56 to "fifty-six",
    57 to "fifty-seven",
    58 to "fifty-eight",
    59 to "fifty-nine",
    60 to "sixty",
    61 to "sixty-one",
    62 to "sixty-two",
    63 to "sixty-three",
    64 to "sixty-four",
    65 to "sixty-five",
    66 to "sixty-six",
    67 to "sixty-seven",
    68 to "sixty-eight",
    69 to "sixty-nine",
    70 to "seventy",
    71 to "seventy-one",
    72 to "seventy-two",
    73 to "seventy-three",
    74 to "seventy-four",
    75 to "seventy-five",
    76 to "seventy-six",
    77 to "seventy-seven",
    78 to "seventy-eight",
    79 to "seventy-nine",
    80 to "eighty",
    81 to "eighty-one",
    82 to "eighty-two",
    83 to "eighty-three",
    84 to "eighty-four",
    85 to "eighty-five",
    86 to "eighty-six",
    87 to "eighty-seven",
    88 to "eighty-eight",
    89 to "eighty-nine",
    90 to "ninety",
    91 to "ninety-one",
    92 to "ninety-two",
    93 to "ninety-three",
    94 to "ninety-four",
    95 to "ninety-five",
    96 to "ninety-six",
    97 to "ninety-seven",
    98 to "ninety-eight",
    99 to "ninety-nine",
    100 to "one hundred"
)





