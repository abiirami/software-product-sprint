// Copyright 2019 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// Copyright 2019 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     https://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

/**
 * Adds a random greeting to the page.
 */
function addRandomQuote() {
  const greetings =
      ['There is enough success out there for all of us - Lily Singh', 'Perhaps the greatest magic of the human spirit is the ability to laugh - Torey Hayden', 'Live as if you were to die tomorrow. Learn as if you were to live forever - Gandhi', 'Don’t bend; don’t water it down; don’t try to make it logical; don’t edit your own soul according to the fashion. Rather, follow your most intense obsessions mercilessly. - Anne Rice', 'The beginning of purpose is found in creating something that only you understand. - Tyler Joseph'];

  // Pick a random greeting.
  const greeting = greetings[Math.floor(Math.random() * greetings.length)];

  // Add it to the page.
  const greetingContainer = document.getElementById('random-quote-container');
  greetingContainer.innerText = greeting;
}

function getComment() {
  fetch('/data').then(response => response.json()).then((myObject) => {
    const comments = JSON.stringify(myObject);
    document.getElementById('comments-container').innerText = comments;
  });
}