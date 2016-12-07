declare variable $in.headers.myParamValue as xs:string external;

<books value='{$in.headers.myParamValue}'>{
          for $x in /bookstore/book
          where $x/price>($in.headers.myParamValue cast as xs:integer)
          order by $x/title
          return $x/title
          }</books>;