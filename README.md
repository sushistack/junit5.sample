# Junit5 샘플 프로젝트

Junit5를 이용 하여 테스트 하는 다양한 편리한 기능들을 확인 해보고,
어떻게 하면 효율적이고 가독성 있게 테스트 코드를 작성할 수 있을지 생각해 본다.  

## 테스트 작성 전략

### 1. ParameterizedTest

Junit5에서 제공 하는 다양한 기능들 중 개인적으로 가장 마음에 드는 기능은 `@ParameterizedTest` + `@XXXSource` 이다.
이를 이용 하면 다양한 케이스에 대한 입력 값과 예상 값을 손쉽게 추가할 수 있고, 가독성도 너무 좋다.
게다가 CSV 파일을 import 해서 사용할 수도 있다.

### 2. Nested Test

> 가독성! 가독성! 가독성!

가독성을 높이고, 구조화 및 계층화된 테스트 보고서를 볼 수 있다.
그래고 같은 중첩 클래스 내에서 공통 부분은 재사용이 가능하다.


### 3. DynamicTest

동적으로 테스트를 생성 하는 기능으로 런타임 시에 테스트에 필요한 초기화 로직, 검증 로직들을 결정할 수 있다고 한다.
또한 생성 되는 테스트들은 각각 독립적인 테스트로 각 테스트 간의 영향 없이 테스트를 작성할 수 있다.

```kt
// Plugin.kt
interface Plugin {
    fun validateResult(result: String)
}

// HelloPlugin.kt
class HelloPlugin : Plugin {
    override fun validateResult(result: String) {
        assertEquals("Hello, World!", result)
    }
}

// GoodbyePlugin.kt
class GoodbyePlugin : Plugin {
    override fun validateResult(result: String) {
        assertEquals("Goodbye, World!", result)
    }
}
```

위와 같이 다형성(Polymorphism)을 이용한 테스트를 작성할 수 있다고 한다. (사실 이건 ParameterizedTest 도 쓸 수 있는 것 아닌가...)


#### 언제 쓸까?

사실 복잡해 보이기만 하고 Parameterized Test 가 훨씬 가독성 있고 직관적, Dynamic Test 는 테스트 대상이 동적으로 변경 되는 경우에 사용 되면 좋음 
예를 들면, playwright 를 이용 하여 외부 웹 사이트에 대한 테스트가 필요한 경우, S3 와 같은 외부 리소스에 대한 테스트가 필요한 경우가 있다.


## 테스트 라이프 사이클

## 테스트 라이프 사이클 콜백

