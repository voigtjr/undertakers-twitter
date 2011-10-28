# undertakers-twitter

A cron job will call this on Sunday afternoon. It will check a data file for a
date and game time.  If there is a game on that date, it'll post a nicely
formatted reminder to Twitter about the game.

# Data file format

```
10/30/2011 22:30
11/6/2011 21:00
11/13/2011 22:30
```

# License

Copyright (c) 2011 Jonathan Voigt and Frank Sinisaj
All rights reserved

Distributed under the Eclipse Public License, the same as Clojure.
http://www.eclipse.org/legal/epl-v10.html
