FILENAME == ARGV[1] { one[FNR]=$2 "\t" }
FILENAME == ARGV[2] { two[FNR]=$0 }
END {
    for (i=1; i<=length(one); i++) {
        print one[i], two[i]
    }
}
