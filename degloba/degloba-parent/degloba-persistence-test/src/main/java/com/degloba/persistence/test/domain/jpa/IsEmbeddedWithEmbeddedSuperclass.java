/*
 * Copyright (C) 2010 Google Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.degloba.persistence.test.domain.jpa;

import javax.persistence.Embeddable;

/**
 * The runtime enhancer has problems with static inner embedded classes that
 * have embeddable super classes, so this class gets its own file.
 *
 * @author Max Ross <max.ross@gmail.com>
*/
@Embeddable
public class IsEmbeddedWithEmbeddedSuperclass extends SubclassesJPA.IsEmbeddedBase {

  private String val1;

  public String getVal1() {
    return val1;
  }

  public void setVal1(String val1) {
    this.val1 = val1;
  }
}
