import { mount, createLocalVue } from '@vue/test-utils'
import RegisterPage from '@/views/RegisterPage'
import { config } from '@vue/test-utils'
import VueRouter from 'vue-router'

config.showDeprecationWarnings = false

// Adding Vue Router to the test so that
// we can access vm.$router
const localVue = createLocalVue()
localVue.use(VueRouter)
const router = new VueRouter()

// Mock dependency registratioService
jest.mock('@/services/registration')

describe('RegisterPage.vue', () => {
  let wrapper
  let fieldUsername
  let fieldEmailAddress
  let fieldPassword
  let buttonSubmit

  beforeEach(() => {
    wrapper = mount(RegisterPage, {
      localVue,
      router
    })
    fieldUsername = wrapper.find('#username')
    fieldEmailAddress = wrapper.find('#emailAddress')
    fieldPassword = wrapper.find('#password')
    buttonSubmit = wrapper.find('form button[type="submit"]')
  })

  afterAll(() => {
    jest.restoreAllMocks()
  })

  it('should render registration form', () => {
    expect(wrapper.find('.logo').attributes().src)
      .toEqual('/static/images/logo.png')
    expect(wrapper.find('.tagline').text())
      .toEqual('Open source task management tool')
    expect(fieldUsername.element.value).toEqual('')
    expect(fieldEmailAddress.element.value).toEqual('')
    expect(fieldPassword.element.value).toEqual('')
    expect(buttonSubmit.text()).toEqual('Create account')
  })

  it('should contain data model with initial values', () => {
    expect(wrapper.vm.form.username).toEqual('')
    expect(wrapper.vm.form.emailAddress).toEqual('')
    expect(wrapper.vm.form.password).toEqual('')
  })

  it('should have form inputs bound with data model', async () => {
    const username = 'sunny'
    const emailAddress = 'sunny@taskagile.com'
    const password = 'VueJsRocks!'

    wrapper.vm.form.username = username
    wrapper.vm.form.emailAddress = emailAddress
    wrapper.vm.form.password = password
    wrapper.vm.$nextTick(null, () => {
      expect(fieldUsername.element.value).toEqual(username)
      expect(fieldEmailAddress.element.value).toEqual(emailAddress)
      expect(fieldPassword.element.value).toEqual(password)
    })
    /*await wrapper.vm.$nextTick()
    expect(fieldUsername.element.value).toEqual(username)
    expect(fieldEmailAddress.element.value).toEqual(emailAddress)
    expect(fieldPassword.element.value).toEqual(password)*/
  })

  it('should have form submit event handler `submitForm`', () => {
    const stub = jest.fn()
    wrapper.setMethods({submitForm: stub})
    buttonSubmit.trigger('submit')
    expect(stub).toBeCalled()
  })

  it('should register when it is a new user', async () => {
    const stub = jest.fn()
    wrapper.vm.$router.push = stub
    wrapper.vm.form.username = 'sunny'
    wrapper.vm.form.emailAddress = 'sunny@taskagile.com'
    wrapper.vm.form.password = 'JestRocks!'
    wrapper.vm.submitForm()
    wrapper.vm.$nextTick(null, () => {
      expect(stub).toHaveBeenCalledWith({name: 'LoginPage'})
    })
    /*await wrapper.vm.$nextTick()
    expect(stub).toHaveBeenCalledWith({name: 'LoginPage'})*/
  })

  it('should fail when it is not a new user', async () => {
    // In the mock, only sunny@taskagile.com is new user
    wrapper.vm.form.username = 'ted'
    wrapper.vm.form.emailAddress = 'ted@taskagile.com'
    wrapper.vm.form.password = 'JestRocks!'

    expect(wrapper.find('.failed').isVisible()).toBe(false)
    wrapper.vm.submitForm()
    wrapper.vm.$nextTick(null, () => {
      expect(wrapper.find('.failed').isVisible()).toBe(true)
    })
  })

})
