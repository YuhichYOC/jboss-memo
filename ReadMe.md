### test01 by Yuichi Yoshii is licensed under the Apache License, Version2.0

### メモ
* リポジトリの検索 : https://central.sonatype.com/
* jar, war, ear ファイルの生成 : mvn clean package
* デバッグ実行について
    1. WildFly をデバッグモードで起動
        * \<WildFly\>/bin/standalone.sh --debug
    1. ear ファイルをデプロイ
        * cp \<ear ファイル\> \<WildFly\>/standalone/deployments/
    1. WildFly プロセスへアタッチ
        * Run and Debug から Debug ( Attach ) - WildFly を選択
