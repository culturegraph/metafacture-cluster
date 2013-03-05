#!/bin/bash

if [ $# -ne 1 ]
then
  echo "Usage: `basename $0` TABLE_NAME"
  exit 65
fi


echo "create '$1', {NAME=>'raw', VERSIONS=>1}, {NAME=>'prop', VERSIONS=>1} " | hbase shell