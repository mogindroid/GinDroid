/* Copyright JS Foundation and other contributors, http://js.foundation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

 class A extends Array {
   constructor (a, b, c) {
     eval ("eval ('super (a, b, c)')");
     eval ("eval ('this.f = 5;')");
     assert (this.h ()()() === 5);

     return { o : 4 };
   }

   g () {
     return function () {
       return 5;
     }
   }
 }

 class B extends A {
   constructor (a, b, c) {
     eval ("eval ('super (a, b, c)')");
     assert (this.f === undefined)
     assert (this.o === 4)
     this.k = 5;
     return { o : 7 };
   }

   h () {
     return super["g"];
   }
 }

 var b = new B (1, 2, 3, 4);
 assert (b.k === undefined);
 assert (b.o === 7);
 assert (b.h === undefined);
 assert (b.g === undefined);
