# Fertilizer

Here: Spring Boot, Kotlin

## How To

Supply with package name of your component classes:

```kotlin
@Configuration
class Config {

    @Bean
    fun fertilizerDialect(): FertilizerDialect {
        return FertilizerDialect("com.stewonello.fertilizer.components")
    }
}
```

The classes created in that package will map to thymeleaf fragment definitions.  
We will just use normal thymeleaf fragments to create our components.

```kotlin
package com.stewonello.fertilizer.components

import com.stewonello.fertilizer.dialect.FertilizerComponent

// Will map to "<templates>/fragments/mycomponent.html"
class MyComponent : FertilizerComponent()
```

Call components/fragments like so:

- `fe:` prefixed attributes will be processed and populated as variable in fragment
- `th:` prefixed will be processed and put onto the root element of the fragment
- unprefixed attributes will just be put onto the root element of the fragment

```html
<div>
    <div th:fragment="~{path/to/component.html :: compoent_other(param, param)}"></div>
    <fe:component class="card" th:data-something="${bla}" fe:foo="${bar}">
      
    </fe:component>
    <fe:mycomponent data-foo="bar" th:data-lorem="${ipsum}" fe:text="'Some Lorem'" fe:foo="${bar}">
</div>
```

Ok ...

## Roadmap

See all the TODO:s in the project

- **CLASS instantiation in TagProcessor oder so .. !!!**
  - register attributes/parameters/signatures ... usw

- Mainly slots
- Compare performance to normal fragment usage
- Scoped variables 🥲
- 🤷‍♀️

### Interface Ideas

- reserve fe: attribute prefix for special fe functionality
  - `fe:path`: supply alternate path to fragment
  - `fe:props`: supply a whole object which will be avaiable as `${props}`? Or extract fields of object? 
- supply "props" via fp: prefix

```html
<fe:my-component fe:path="other/path/to" fe:props="${objectWithProps}" fp:foo="${singleProp}" 
                 th:data-foo="${toFragmentRoot}" class="add classes to fragment root">
    The Content
</fe:my-component>

```