(defproject advent2017 "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [expectations "2.2.0-rc3"]]
  :test-refresh {
                  :changes-only true
                  :notify-command ["terminal-notifier" "-title" "Advent 2016 Tests" "-message"]})
